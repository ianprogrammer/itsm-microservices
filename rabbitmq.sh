
echo "Configuring RabbitMQ"

echo "Exchanges"

sudo docker exec -it rabbitmq rabbitmqadmin declare exchange name=eventbuilder.processor type=direct -u rabbituser -p P@ssw0rd
sudo docker exec -it rabbitmq rabbitmqadmin declare exchange name=ticket.email type=fanout -u rabbituser -p P@ssw0rd

echo "Queues"
sudo docker exec -it rabbitmq rabbitmqadmin declare queue name=eventbuilder.processor.queue durable=true -u rabbituser -p P@ssw0rd
sudo docker exec -it rabbitmq rabbitmqadmin declare queue name=ticket.email.queue durable=true -u rabbituser -p P@ssw0rd

echo "Binding"
sudo docker exec -it rabbitmq rabbitmqadmin declare binding source=eventbuilder.processor destination=eventbuilder.processor.queue routing_key=eventbuilder.processor.queue -u rabbituser -p P@ssw0rd
sudo docker exec -it rabbitmq rabbitmqadmin declare binding source=ticket.email destination=ticket.email.queue routing_key=ticket.email.queue -u rabbituser -p P@ssw0rd