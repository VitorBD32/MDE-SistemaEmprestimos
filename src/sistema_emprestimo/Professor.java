/**
 */
package sistema_emprestimo;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Professor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link sistema_emprestimo.Professor#getNome <em>Nome</em>}</li>
 *   <li>{@link sistema_emprestimo.Professor#getMatricula <em>Matricula</em>}</li>
 *   <li>{@link sistema_emprestimo.Professor#getDepartamento <em>Departamento</em>}</li>
 * </ul>
 *
 * @see sistema_emprestimo.Sistema_emprestimoPackage#getProfessor()
 * @model
 * @generated
 */
public interface Professor extends EObject {
	/**
	 * Returns the value of the '<em><b>Nome</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nome</em>' attribute.
	 * @see #setNome(String)
	 * @see sistema_emprestimo.Sistema_emprestimoPackage#getProfessor_Nome()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	String getNome();

	/**
	 * Sets the value of the '{@link sistema_emprestimo.Professor#getNome <em>Nome</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nome</em>' attribute.
	 * @see #getNome()
	 * @generated
	 */
	void setNome(String value);

	/**
	 * Returns the value of the '<em><b>Matricula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matricula</em>' attribute.
	 * @see #setMatricula(String)
	 * @see sistema_emprestimo.Sistema_emprestimoPackage#getProfessor_Matricula()
	 * @model
	 * @generated
	 */
	String getMatricula();

	/**
	 * Sets the value of the '{@link sistema_emprestimo.Professor#getMatricula <em>Matricula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matricula</em>' attribute.
	 * @see #getMatricula()
	 * @generated
	 */
	void setMatricula(String value);

	/**
	 * Returns the value of the '<em><b>Departamento</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Departamento</em>' attribute.
	 * @see #setDepartamento(String)
	 * @see sistema_emprestimo.Sistema_emprestimoPackage#getProfessor_Departamento()
	 * @model
	 * @generated
	 */
	String getDepartamento();

	/**
	 * Sets the value of the '{@link sistema_emprestimo.Professor#getDepartamento <em>Departamento</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Departamento</em>' attribute.
	 * @see #getDepartamento()
	 * @generated
	 */
	void setDepartamento(String value);

} // Professor
