
all:
	mvn clean install -DskipTests

clean:
	mvn clean

release:
	mvn clean deploy -DskipTests -Dgpg.passphrase=${GPG_PASSPHRASE} -Pci-cd
