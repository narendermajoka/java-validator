[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.imNirav.java.validator/java-validator/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.imNirav.java.validator/java-validator).

# java-validator

This is a helper library in order to validate null and empty value of members of the Java class at Class level. It is intended to reduce boilerplate code i.e. it reduces the time frame to check the values of indiviual members of the class by using multiple conditional statements. We can even check the object at hierarchical level i.e. the members of the member object can also be validated at the same time. We can also provide a custom message that is to be displayed whenever validation fails. It can check null and empty object of Array, CharSequence, Collection, Map.

## Adding to project

To use this library, add these dependencies to build.gradle 
```
repositories {
   mavenCentral()
	}
  dependencies {
    compile 'com.github.imNirav.java.validator:java-validator:1.0.1'
} 
```
in pom.xml
```
<dependency>
    <groupId>com.github.imNirav.java.validator</groupId>
    <artifactId>java-validator</artifactId>
    <version>1.0.1</version>
</dependency>
```
## Simple usage
Annotate the class with members that you need to validate,
validation result will come in BindingResult object.
you can also add your custom message in 'message' attribute,shown when validation fails.

```
@CheckForNull(required="{name,age,address,address.street}")
public class Person {
	String name;
	Integer age;
	Address address;
}
------------------------------------------------------------

public ResponseEntity<Response> getPersonAddress(@Valid @RequestBody
   Person person, BindingResult result) throws Exception {
   
		if (result.hasErrors()) {
			//handle errors here
		}
    
}
------------------------------------------------------------
```
## Links
* [Maven-central](https://maven-badges.herokuapp.com/maven-central/com.github.imNirav.java.validator/java-validator) - Dependency Management

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
