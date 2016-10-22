# Examples
<b>QueryBuilder example:</b><br>
```java
Person p = Person.newQuery().results().random();
Person oldPerson = Person.newQuery().ages(99).results().random();
Person mihael = Person.newQuery().names("Mihael").results().random();

/*System.out.println(p.getName() + " -> " + p.getAge());*/
```
<b>QueryBuilder output: </b> <br />

Mihael -> 17<br>
Party -> 99<br>
00:00:00:65

