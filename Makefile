
all:
	mvn clean install -DskipTests

clean:
	mvn clean

release:
	mvn clean deploy -DskipTests -Dmaven.javadoc.skip=true -Dgpg.passphrase=${GPG_PASSPHRASE} -Pci-cd
