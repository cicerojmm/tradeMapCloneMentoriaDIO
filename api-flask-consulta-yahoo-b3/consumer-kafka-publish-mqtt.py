from kafka import KafkaConsumer
import json
import paho.mqtt.client as paho

#configuração do MQTT
broker = "test.mosquitto.org"
port = 1883

def on_publish(client, userdata, result):
    pass

client = paho.Client("acoesb3-mqtt")
client.on_publish = on_publish
client.connect(broker,port)

#configuração do kafka
brokers = ['localhost:9092']
topico = 'acao.b3.dados'
consumer = KafkaConsumer(topico, group_id = 'group1', bootstrap_servers = brokers)

for messagem in consumer:
    texto = json.loads(messagem.value.decode('utf-8'))
    client.publish("acao.b3.dados", str(texto))
    print(texto)
