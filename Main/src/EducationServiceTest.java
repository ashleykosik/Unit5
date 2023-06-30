import java.util.Arrays;

public class EducationServiceTest {

    //step 1
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private StudentDataObject studentDataObject;

    @Mock
    private InstructorDataObject instructorDataObject;

    @Mock
    private ClassDataObject classDataObject;

    @InjectMocks
    private ClientBusinessObjectImpl clientBusinessObjectImpl;

    //step 2
    @Test
    public void testStudentsByClass() {
        Student student JM = new Student(“Joy Ma”, “Spanish);
        Student student JH = new Student(“Julio Hernandez”, “Algebra”);
        Student student JJ = new Student(“Jenny Jones”, “Calculus”);
        List<Student> allStudents = Arrays.asList(studentJM, studentJH, studentJJ);
        given(studentDataObject.getAllStudents()).willReturn(allStudents);

        List<String> mathStudents = clientBusinessObjectImpl.getAllStudentsBySubject(“math”);
        assertThat(mathStudents.size(), is(2));
        assertThat(mathStudents, hasItems(studentJJ, student JH);
    }

    // step 3
    @Test
    public void testMarkInactive() {


        Class geometry = new Class(“Geometry”, “Summer 2022);
        Class envSci = new Class(“Environmental Science”, “Fall 2022”);
        Class compLit = new Class(“Comparative Literature”, “Spring 2023”);
        List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

        given(classDataObject.getAllClasses()).willReturn(allClasses);

        clientBusinessObjectImpl.markCurrentClassesInactive();

        verify(classDataObject).markInactive(geometry);

        verify(classDataObject, Mockito.never()).markInactive(envSci);

        verify(classDataObject, Mockito.never()).markInactive(compLit);

        verify(classDataObject, Mockito.times(1)).markInactive(geometry);

    }

    //step 4
    @Captor
    ArgumentCaptor<Class> classArgumentCaptor;

    @Test
    public void testMarkInactive_argumentCaptor() {

        Class geometry = new Class(“Geometry”, “Summer 2022);
        Class envSci = new Class(“Environmental Science”, “Fall 2022”);
        Class compLit = new Class(“Comparative Literature”, “Spring 2023”);
        List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);
        given(classDataObject.getAllClasses()).willReturn(allClasses);

        clientBusinessObjectImpl.markCurrentClassesInactive();

        verify(classDataObject).markInactive(classArgumentCaptor.capture());

        assertEquals(geometry, classArgumentCaptor.getValue());
    }

    //Step 5 - test these: InstructorDataObject.getClassesByInstructor(instructor_id)

        //create instructor objects - they need ids & classes they teach
        Instructor instructor 01 = new Instructor("Jerri", "Math 101", "Math 102", "Math 103")
        List<Class> allInstructors = Array.asList(instructor01);

        //return only classes after inputting teacher id
        given(InstructorDataObject.getClassesByInstructor()).willReturn(allInstructors);
        List<String> instructorsClasses = clientBusinessObjectImpl.getClassesByInstructor("Jerri");
        assertThat(instructorsClasses.size(), is(1));
        assertThat(instructorsClasses, hasItems(instructor01));


    // ClassDataObject.getStudentsInClass(class_id)
        // create students all in the same class
        Student student JM = new Student("Joy Ma", "Spanish");
        Student student JH = new Student ("Julio Hernandez", "Spanish");
        Student student JJ = new Student("Jenny Jones", "Spanish");
        List<Class> allStudents = Arrays.asList(studentJM, studentJH, studentJJ);

        given(ClassDataObject.getStudentsInClass()).willReturn(allStudents);

        //when
        List <String> spanishStudents = clientBusinessObjectImpl.getStudentsInClass("spanish");
        assertThat(spanishStudents.size(), is(3));
        assertThat(spanishStudents, hasItems(studentJM, studentJH, studentJJ));

}
