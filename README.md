# HomeEnergyManager

Autonomous energy management for a smart device equipped home


To run a scenario on mono-JVM, run the CVM class

To run a scenario on multi-JVM, it is required to run bash scripts using jdk-14 (is the new version of BCM in java 14 ? the project was made in java 8...)
1.	you must change the path to YOUR jre in the dcvm.policy file
2.	execute the scripts in order :
	./start-gregistry
	./start-cyclicbarrier
	./start-dcvm jvmController-uri
	./start-dcvm jvmEnergyCounter-uri
	./start-dcvm jvmEquipments-uri