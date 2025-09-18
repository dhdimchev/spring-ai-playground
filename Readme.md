# Spring AI Playground

This exists in order to try things with Spring Ai and keep examples for later use.

To Run:
- Env variable OPEN_AI_KEY must be set on the environment.
- Run: mvn spring-boot:run

Endpoints(Better check Spring Actuator)
- GET /                      → returns a Bulgarian joke (ChatResponse)
- GET /chat?message=...      → simple text reply
- GET /stream                → streaming reply (SSE)
- GET /article/new?topic=... → blog post with system message
- GET /dimobank/info?message=... → bank assistant with guardrails
- GET /vacation/structured   → JSON mapped to Schedule/Activity


