/**
 */
package sistema_emprestimo.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import sistema_emprestimo.Equipamento;
import sistema_emprestimo.Sistema_emprestimoFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Equipamento</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EquipamentoTest extends TestCase {

	/**
	 * The fixture for this Equipamento test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Equipamento fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EquipamentoTest.class);
	}

	/**
	 * Constructs a new Equipamento test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquipamentoTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Equipamento test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Equipamento fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Equipamento test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Equipamento getFixture() {
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
		setFixture(Sistema_emprestimoFactory.eINSTANCE.createEquipamento());
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

} //EquipamentoTest
