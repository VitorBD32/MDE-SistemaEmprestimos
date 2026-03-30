/**
 */
package sistema_emprestimo;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Emprestimo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link sistema_emprestimo.Emprestimo#getDataRetirada <em>Data Retirada</em>}</li>
 *   <li>{@link sistema_emprestimo.Emprestimo#getDataDevolucaoPrevista <em>Data Devolucao Prevista</em>}</li>
 *   <li>{@link sistema_emprestimo.Emprestimo#getEquipamentoEmprestado <em>Equipamento Emprestado</em>}</li>
 *   <li>{@link sistema_emprestimo.Emprestimo#getProfessorResponsavel <em>Professor Responsavel</em>}</li>
 * </ul>
 *
 * @see sistema_emprestimo.Sistema_emprestimoPackage#getEmprestimo()
 * @model
 * @generated
 */
public interface Emprestimo extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Retirada</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Retirada</em>' attribute.
	 * @see #setDataRetirada(Date)
	 * @see sistema_emprestimo.Sistema_emprestimoPackage#getEmprestimo_DataRetirada()
	 * @model
	 * @generated
	 */
	Date getDataRetirada();

	/**
	 * Sets the value of the '{@link sistema_emprestimo.Emprestimo#getDataRetirada <em>Data Retirada</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Retirada</em>' attribute.
	 * @see #getDataRetirada()
	 * @generated
	 */
	void setDataRetirada(Date value);

	/**
	 * Returns the value of the '<em><b>Data Devolucao Prevista</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Devolucao Prevista</em>' attribute.
	 * @see #setDataDevolucaoPrevista(Date)
	 * @see sistema_emprestimo.Sistema_emprestimoPackage#getEmprestimo_DataDevolucaoPrevista()
	 * @model
	 * @generated
	 */
	Date getDataDevolucaoPrevista();

	/**
	 * Sets the value of the '{@link sistema_emprestimo.Emprestimo#getDataDevolucaoPrevista <em>Data Devolucao Prevista</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Devolucao Prevista</em>' attribute.
	 * @see #getDataDevolucaoPrevista()
	 * @generated
	 */
	void setDataDevolucaoPrevista(Date value);

	/**
	 * Returns the value of the '<em><b>Equipamento Emprestado</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equipamento Emprestado</em>' reference.
	 * @see #setEquipamentoEmprestado(Equipamento)
	 * @see sistema_emprestimo.Sistema_emprestimoPackage#getEmprestimo_EquipamentoEmprestado()
	 * @model
	 * @generated
	 */
	Equipamento getEquipamentoEmprestado();

	/**
	 * Sets the value of the '{@link sistema_emprestimo.Emprestimo#getEquipamentoEmprestado <em>Equipamento Emprestado</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Equipamento Emprestado</em>' reference.
	 * @see #getEquipamentoEmprestado()
	 * @generated
	 */
	void setEquipamentoEmprestado(Equipamento value);

	/**
	 * Returns the value of the '<em><b>Professor Responsavel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Professor Responsavel</em>' reference.
	 * @see #setProfessorResponsavel(Equipamento)
	 * @see sistema_emprestimo.Sistema_emprestimoPackage#getEmprestimo_ProfessorResponsavel()
	 * @model
	 * @generated
	 */
	Equipamento getProfessorResponsavel();

	/**
	 * Sets the value of the '{@link sistema_emprestimo.Emprestimo#getProfessorResponsavel <em>Professor Responsavel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Professor Responsavel</em>' reference.
	 * @see #getProfessorResponsavel()
	 * @generated
	 */
	void setProfessorResponsavel(Equipamento value);

} // Emprestimo
