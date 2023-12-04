# tapr-2023-equipe2-matricula-java

## Autenticação no AZURE
[DOC](https://learn.microsoft.com/en-us/cli/azure/install-azure-cli-linux?pivots=apt)

```
az login -u marcos.godinho@univille.br
az login --use-device-code

az ad signed-in-user show

HATEOAS em APIs Restful

#Executar esse comando dentro da pasta do projeto
mvn clean install
dapr run -f .

#Exemplo de publicação de atualização do evento
# dapr publish --publish-app-id <nome da aplicação no arquivo dapr.yaml> --pubsub <nome do componente do service bus no arquivo /componenets/servicebus-pubsub.yaml> --topic <nome do topico registrado no service bus> --data '<objeto JSON contendo os campos da entidade>'

dapr publish --publish-app-id tapr-2023-equipe2-matricula-java --pubsub servicebus-pubsub --topic topico-equipe-2-disciplina --data '{"id": "123","nome": "Zezinho"}'
```