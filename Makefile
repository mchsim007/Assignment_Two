JAVAC = /bin/src/

.SUFFIXES: .java.class

.java.class:
		$(JAVAC) $<
		
default: *.class