/**
 */
package sistema_emprestimo.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import sistema_emprestimo.Professor;
import sistema_emprestimo.Sistema_emprestimoFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Professor</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProfessorTest extends TestCase {

	/**
	 * The fixture for this Professor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Professor fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ProfessorTest.class);
	}

	/**
	 * Constructs a new Professor test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfessorTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Professor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Professor fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Professor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Professor getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(Sistema_emprestimoFactory.eINSTANCE.createProfessor());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ProfessorTest
