# vault-demo-app
HashiCorp Vault / Quarkus Demo App


mvn io.quarkus:quarkus-maven-plugin:1.13.6.Final:create \
    -DprojectGroupId=navy.elos \
    -DprojectArtifactId=vault-app-demo \
    -DclassName="navy.elos.app.AuditResource" \
    -Dpath="/audit" \
    -Dextensions="resteasy,vault,quarkus-hibernate-orm,quarkus-jdbc-postgresql"

cat <<EOF | vault policy write vault-kvdb-policy -
path "secret/data/myapps/vault-kvdb/*" {
  capabilities = ["read"]
}
EOF