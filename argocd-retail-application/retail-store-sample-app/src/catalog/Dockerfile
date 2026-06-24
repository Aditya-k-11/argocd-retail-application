FROM golang:1.23 AS builder

WORKDIR /app

COPY go.mod go.sum ./
RUN go mod download

COPY . .

RUN apt-get update && apt-get install -y gcc libc6-dev

RUN CGO_ENABLED=1 GOOS=linux go build -o catalog .

FROM debian:bookworm-slim

WORKDIR /app

COPY --from=builder /app/catalog .

EXPOSE 8080

ENTRYPOINT ["./catalog"]
