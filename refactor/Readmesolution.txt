Use Java 7
Database driver should be put in classpath, assumed that it is Oracle.
There is no need to make Class.forName() call(for Java 7).
It is preferable to create connection pool(Hikary or BoneCP also could be used) on app server, and get dataSource through JNDI  
Refactored code in "refactored" folder