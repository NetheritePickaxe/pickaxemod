#!/bin/bash

FEISHU_WEBHOOK_URL="${FEISHU_WEBHOOK_URL:-}"
NOTIFY_STATUS="${NOTIFY_STATUS:-success}"

if [ -z "$FEISHU_WEBHOOK_URL" ]; then
  echo "FEISHU_WEBHOOK_URL not set, skipping notification"
  exit 0
fi

TRIGGER_EVENT="${TRIGGER_EVENT:-unknown}"
BRANCH="${BRANCH:-unknown}"
COMMIT_SHA="${COMMIT_SHA:-0000000}"
COMMIT_MSG="${COMMIT_MSG:-}"
ACTOR="${ACTOR:-unknown}"
RUN_URL="${RUN_URL:-}"
BUILD_DURATION="${BUILD_DURATION:-}"
RELEASE_TAG="${RELEASE_TAG:-}"

COMMIT_SHORT=$(echo "$COMMIT_SHA" | cut -c1-7)
COMMIT_MSG_FIRST=$(echo "$COMMIT_MSG" | head -n 1 | cut -c1-100)

case "$TRIGGER_EVENT" in
  push) TRIGGER_LABEL="代码推送" ;;
  pull_request) TRIGGER_LABEL="Pull Request" ;;
  workflow_dispatch) TRIGGER_LABEL="手动触发" ;;
  *) TRIGGER_LABEL="$TRIGGER_EVENT" ;;
esac

if [ -n "$RELEASE_TAG" ]; then
  TITLE="🎉 Pickaxe Mod $RELEASE_TAG 发布"
  HEADER_COLOR="blue"
  NOTIFY_STATUS="success"
else
  case "$NOTIFY_STATUS" in
    success)
      TITLE="✅ Pickaxe Mod 构建成功"
      HEADER_COLOR="green"
      ;;
    failure)
      TITLE="❌ Pickaxe Mod 构建失败"
      HEADER_COLOR="red"
      ;;
    cancelled)
      TITLE="⏹️ Pickaxe Mod 构建已取消"
      HEADER_COLOR="grey"
      ;;
    *)
      TITLE="ℹ️ Pickaxe Mod 构建状态: $NOTIFY_STATUS"
      HEADER_COLOR="blue"
      ;;
  esac
fi

CONTENT="**触发方式**: $TRIGGER_LABEL"

if [ -n "$RELEASE_TAG" ]; then
  CONTENT="$CONTENT\n**版本**: $RELEASE_TAG"
fi

CONTENT="$CONTENT\n**分支**: $BRANCH"

if [ -n "$COMMIT_MSG_FIRST" ]; then
  CONTENT="$CONTENT\n**提交**: [$COMMIT_SHORT] $COMMIT_MSG_FIRST"
fi

CONTENT="$CONTENT\n**作者**: $ACTOR"

if [ -n "$BUILD_DURATION" ]; then
  CONTENT="$CONTENT\n**耗时**: $BUILD_DURATION"
fi

if [ -n "$RUN_URL" ]; then
  CONTENT="$CONTENT\n\n🔗 [查看运行详情]($RUN_URL)"
fi

PAYLOAD=$(cat <<EOF
{
  "msg_type": "interactive",
  "card": {
    "header": {
      "title": {
        "tag": "plain_text",
        "content": "$TITLE"
      },
      "template": "$HEADER_COLOR"
    },
    "elements": [
      {
        "tag": "markdown",
        "content": "$CONTENT"
      }
    ]
  }
}
EOF
)

response=$(curl -s -o /dev/null -w "%{http_code}" \
  -X POST "$FEISHU_WEBHOOK_URL" \
  -H "Content-Type: application/json" \
  -d "$PAYLOAD")

if [ "$response" -eq 200 ]; then
  echo "Feishu notification sent successfully (HTTP $response)"
else
  echo "Feishu notification failed (HTTP $response)"
  exit 1
fi
