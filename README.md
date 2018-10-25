# EJBHibernate
EJB JSF Hibernate on Wildfly


module add --name=org.postgresql --slot=main --resources=C:\Users\Kafein\.m2\repository\org\postgresql\postgresql\42.2.5\postgresql-42.2.5.jar --dependencies=javax.api,javax.transaction.api


/subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres",driver-module-name="org.postgres",driver-class-name=org.postgresql.Driver)


