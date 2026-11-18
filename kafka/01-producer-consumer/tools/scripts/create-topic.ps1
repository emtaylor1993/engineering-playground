param(
    [string]$Topic = "claims.submitted",
    [int]$Partitions = 1
)

$Container = "kafka-producer-consumer-lab"

docker exec $container /opt/kafka/bin/kafka-topics.sh `
  --create `
  --if-not-exists `
  --topic $Topic `
  --bootstrap-server localhost:9092 `
  --partitions $Partitions `
  --replication-factor 1

if ($LASTEXITCODE -ne 0) {
    throw "Failed to create Kafka topic: $Topic"
}

docker exec $Container /opt/kafka/bin/kafka-topics.sh `
  --describe `
  --topic $Topic `
  --bootstrap-server localhost:9092

if ($LASTEXITCODE -ne 0) {
    throw "Failed to describe Kafka topic: $Topic"
}