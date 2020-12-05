from kafka import KafkaConsumer
import json

#configuração do kafka
brokers = ['localhost:9092']
topico = 'acao.b3.dados'

consumer = KafkaConsumer(topico, group_id = 'group1', bootstrap_servers = brokers)

for messagem in consumer:
    texto = json.loads(messagem.value.decode('utf-8'))
    print(texto)
