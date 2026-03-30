/**
 */
package sistema_emprestimo;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see sistema_emprestimo.Sistema_emprestimoPackage
 * @generated
 */
public interface Sistema_emprestimoFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Sistema_emprestimoFactory eINSTANCE = sistema_emprestimo.impl.Sistema_emprestimoFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Professor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Professor</em>'.
	 * @generated
	 */
	Professor createProfessor();

	/**
	 * Returns a new object of class '<em>Equipamento</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equipamento</em>'.
	 * @generated
	 */
	Equipamento createEquipamento();

	/**
	 * Returns a new object of class '<em>Emprestimo</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Emprestimo</em>'.
	 * @generated
	 */
	Emprestimo createEmprestimo();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Sistema_emprestimoPackage getSistema_emprestimoPackage();

} //Sistema_emprestimoFactory
