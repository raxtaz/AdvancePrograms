import java.util.Optional;

public class OptionalExample
{

	static class Student
	{

		int id;
		String name;
		String email;

		Student(int id, String name, String email)
		{
			this.id = id;
			this.name = name;
			this.email = email;
		}

		public String getName()
		{
			return name;
		}

		public String getEmail()
		{
			return email;
		}

		@Override
		public String toString()
		{
			return "Student{id=" + id +
					", name='" + name + '\'' +
					", email='" + email + '\'' +
					'}';
		}
	}

	// Simulating a database search
	public static Optional<Student> findStudentById(int id)
	{

		if(id == 101)
		{
			return Optional.of(
					new Student(101, "Rahul", "rahul@gmail.com")
			);
		}

		return Optional.empty();
	}

	public static void main(String[] args)
	{

		// ------------------------------------------------
		// 1. Student EXISTS
		// ------------------------------------------------

		Optional<Student> result1 = findStudentById(101);

		System.out.println("\nResult 1:");
		System.out.println(result1);


		// ------------------------------------------------
		// 2. Check whether value exists
		// ------------------------------------------------

		System.out.println("\nIs student present?");

		if(result1.isPresent())
		{
			System.out.println("Student exists");
		}
		else
		{
			System.out.println("Student does not exist");
		}


		// ------------------------------------------------
		// 3. ifPresent()
		// ------------------------------------------------

		System.out.println("\nUsing ifPresent():");

		result1.ifPresent(student ->
				System.out.println("Student name: " + student.getName())
		);


		// ------------------------------------------------
		// 4. Student DOES NOT EXIST
		// ------------------------------------------------

		Optional<Student> result2 = findStudentById(999);

		System.out.println("\nResult 2:");
		System.out.println(result2);


		// ------------------------------------------------
		// 5. orElse()
		// ------------------------------------------------

		Student student1 = result2.orElse(
				new Student(0, "Unknown", "No email")
		);

		System.out.println("\nUsing orElse():");
		System.out.println(student1);


		// ------------------------------------------------
		// 6. orElseGet()
		// ------------------------------------------------

		Student student2 = result2.orElseGet(() ->
		{

			System.out.println("Creating default student...");

			return new Student(
					0,
					"Default Student",
					"default@gmail.com"
			);
		});

		System.out.println(student2);


		// ------------------------------------------------
		// 7. orElseThrow()
		// ------------------------------------------------

		try
		{

			Student student3 = result2.orElseThrow(
					() -> new RuntimeException("Student not found")
			);

			System.out.println(student3);

		}
		catch(RuntimeException e)
		{

			System.out.println("\nException: " + e.getMessage());
		}


		// ------------------------------------------------
		// 8. map()
		// ------------------------------------------------

		System.out.println("\nUsing map():");

		Optional<String> studentName =
				result1.map(Student :: getName);

		System.out.println(studentName);


		// ------------------------------------------------
		// 9. filter()
		// ------------------------------------------------

		System.out.println("\nUsing filter():");

		Optional<Student> filteredStudent =
				result1.filter(student -> student.getName().equals("Rahul"));

		System.out.println(filteredStudent);


		// ------------------------------------------------
		// 10. filter() fails
		// ------------------------------------------------

		Optional<Student> filteredStudent2 =
				result1.filter(student -> student.getName().equals("Amit"));

		System.out.println(filteredStudent2);
	}
}