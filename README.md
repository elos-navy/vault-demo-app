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

vault write auth/kubernetes/role/vault-kvdb-role \
    bound_service_account_names=vault-auth-sa \
    bound_service_account_namespaces=vault \
    policies=vault-kvdb-policy \
    ttl=1h