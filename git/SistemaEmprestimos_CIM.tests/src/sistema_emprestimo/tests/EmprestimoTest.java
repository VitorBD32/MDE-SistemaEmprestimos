/**
 */
package sistema_emprestimo.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import sistema_emprestimo.Emprestimo;
import sistema_emprestimo.Sistema_emprestimoFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Emprestimo</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EmprestimoTest extends TestCase {

	/**
	 * The fixture for this Emprestimo test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Emprestimo fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EmprestimoTest.class);
	}

	/**
	 * Constructs a new Emprestimo test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmprestimoTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Emprestimo test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Emprestimo fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Emprestimo test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Emprestimo getFixture() {
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
		setFixture(Sistema_emprestimoFactory.eINSTANCE.createEmprestimo());
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

} //EmprestimoTest
