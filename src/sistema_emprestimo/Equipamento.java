/**
 */
package sistema_emprestimo;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equipamento</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link sistema_emprestimo.Equipamento#getNome <em>Nome</em>}</li>
 *   <li>{@link sistema_emprestimo.Equipamento#getCodigoTombamento <em>Codigo Tombamento</em>}</li>
 *   <li>{@link sistema_emprestimo.Equipamento#isIsDisponivel <em>Is Disponivel</em>}</li>
 * </ul>
 *
 * @see sistema_emprestimo.Sistema_emprestimoPackage#getEquipamento()
 * @model
 * @generated
 */
public interface Equipamento extends EObject {
	/**
	 * Returns the value of the '<em><b>Nome</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nome</em>' attribute.
	 * @see #setNome(String)
	 * @see sistema_emprestimo.Sistema_emprestimoPackage#getEquipamento_Nome()
	 * @model
	 * @generated
	 */
	String getNome();

	/**
	 * Sets the value of the '{@link sistema_emprestimo.Equipamento#getNome <em>Nome</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nome</em>' attribute.
	 * @see #getNome()
	 * @generated
	 */
	void setNome(String value);

	/**
	 * Returns the value of the '<em><b>Codigo Tombamento</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Codigo Tombamento</em>' attribute.
	 * @see #setCodigoTombamento(int)
	 * @see sistema_emprestimo.Sistema_emprestimoPackage#getEquipamento_CodigoTombamento()
	 * @model
	 * @generated
	 */
	int getCodigoTombamento();

	/**
	 * Sets the value of the '{@link sistema_emprestimo.Equipamento#getCodigoTombamento <em>Codigo Tombamento</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Codigo Tombamento</em>' attribute.
	 * @see #getCodigoTombamento()
	 * @generated
	 */
	void setCodigoTombamento(int value);

	/**
	 * Returns the value of the '<em><b>Is Disponivel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Disponivel</em>' attribute.
	 * @see #setIsDisponivel(boolean)
	 * @see sistema_emprestimo.Sistema_emprestimoPackage#getEquipamento_IsDisponivel()
	 * @model
	 * @generated
	 */
	boolean isIsDisponivel();

	/**
	 * Sets the value of the '{@link sistema_emprestimo.Equipamento#isIsDisponivel <em>Is Disponivel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Disponivel</em>' attribute.
	 * @see #isIsDisponivel()
	 * @generated
	 */
	void setIsDisponivel(boolean value);

} // Equipamento
