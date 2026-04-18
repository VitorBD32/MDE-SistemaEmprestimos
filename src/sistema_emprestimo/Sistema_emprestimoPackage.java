/**
 */
package sistema_emprestimo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see sistema_emprestimo.Sistema_emprestimoFactory
 * @model kind="package"
 * @generated
 */
public interface Sistema_emprestimoPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sistema_emprestimo";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/sistemaemprestimo";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sistemaemprestimo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Sistema_emprestimoPackage eINSTANCE = sistema_emprestimo.impl.Sistema_emprestimoPackageImpl.init();

	/**
	 * The meta object id for the '{@link sistema_emprestimo.impl.ProfessorImpl <em>Professor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sistema_emprestimo.impl.ProfessorImpl
	 * @see sistema_emprestimo.impl.Sistema_emprestimoPackageImpl#getProfessor()
	 * @generated
	 */
	int PROFESSOR = 0;

	/**
	 * The feature id for the '<em><b>Nome</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR__NOME = 0;

	/**
	 * The feature id for the '<em><b>Matricula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR__MATRICULA = 1;

	/**
	 * The feature id for the '<em><b>Departamento</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR__DEPARTAMENTO = 2;

	/**
	 * The number of structural features of the '<em>Professor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Professor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link sistema_emprestimo.impl.EquipamentoImpl <em>Equipamento</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sistema_emprestimo.impl.EquipamentoImpl
	 * @see sistema_emprestimo.impl.Sistema_emprestimoPackageImpl#getEquipamento()
	 * @generated
	 */
	int EQUIPAMENTO = 1;

	/**
	 * The feature id for the '<em><b>Nome</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPAMENTO__NOME = 0;

	/**
	 * The feature id for the '<em><b>Codigo Tombamento</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPAMENTO__CODIGO_TOMBAMENTO = 1;

	/**
	 * The feature id for the '<em><b>Is Disponivel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPAMENTO__IS_DISPONIVEL = 2;

	/**
	 * The number of structural features of the '<em>Equipamento</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPAMENTO_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Equipamento</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPAMENTO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link sistema_emprestimo.impl.EmprestimoImpl <em>Emprestimo</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sistema_emprestimo.impl.EmprestimoImpl
	 * @see sistema_emprestimo.impl.Sistema_emprestimoPackageImpl#getEmprestimo()
	 * @generated
	 */
	int EMPRESTIMO = 2;

	/**
	 * The feature id for the '<em><b>Data Retirada</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPRESTIMO__DATA_RETIRADA = 0;

	/**
	 * The feature id for the '<em><b>Data Devolucao Prevista</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPRESTIMO__DATA_DEVOLUCAO_PREVISTA = 1;

	/**
	 * The feature id for the '<em><b>Equipamento Emprestado</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPRESTIMO__EQUIPAMENTO_EMPRESTADO = 2;

	/**
	 * The feature id for the '<em><b>Professor Responsavel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPRESTIMO__PROFESSOR_RESPONSAVEL = 3;

	/**
	 * The number of structural features of the '<em>Emprestimo</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPRESTIMO_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Emprestimo</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPRESTIMO_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link sistema_emprestimo.Professor <em>Professor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Professor</em>'.
	 * @see sistema_emprestimo.Professor
	 * @generated
	 */
	EClass getProfessor();

	/**
	 * Returns the meta object for the attribute '{@link sistema_emprestimo.Professor#getNome <em>Nome</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nome</em>'.
	 * @see sistema_emprestimo.Professor#getNome()
	 * @see #getProfessor()
	 * @generated
	 */
	EAttribute getProfessor_Nome();

	/**
	 * Returns the meta object for the attribute '{@link sistema_emprestimo.Professor#getMatricula <em>Matricula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Matricula</em>'.
	 * @see sistema_emprestimo.Professor#getMatricula()
	 * @see #getProfessor()
	 * @generated
	 */
	EAttribute getProfessor_Matricula();

	/**
	 * Returns the meta object for the attribute '{@link sistema_emprestimo.Professor#getDepartamento <em>Departamento</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Departamento</em>'.
	 * @see sistema_emprestimo.Professor#getDepartamento()
	 * @see #getProfessor()
	 * @generated
	 */
	EAttribute getProfessor_Departamento();

	/**
	 * Returns the meta object for class '{@link sistema_emprestimo.Equipamento <em>Equipamento</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equipamento</em>'.
	 * @see sistema_emprestimo.Equipamento
	 * @generated
	 */
	EClass getEquipamento();

	/**
	 * Returns the meta object for the attribute '{@link sistema_emprestimo.Equipamento#getNome <em>Nome</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nome</em>'.
	 * @see sistema_emprestimo.Equipamento#getNome()
	 * @see #getEquipamento()
	 * @generated
	 */
	EAttribute getEquipamento_Nome();

	/**
	 * Returns the meta object for the attribute '{@link sistema_emprestimo.Equipamento#getCodigoTombamento <em>Codigo Tombamento</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Codigo Tombamento</em>'.
	 * @see sistema_emprestimo.Equipamento#getCodigoTombamento()
	 * @see #getEquipamento()
	 * @generated
	 */
	EAttribute getEquipamento_CodigoTombamento();

	/**
	 * Returns the meta object for the attribute '{@link sistema_emprestimo.Equipamento#isIsDisponivel <em>Is Disponivel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Disponivel</em>'.
	 * @see sistema_emprestimo.Equipamento#isIsDisponivel()
	 * @see #getEquipamento()
	 * @generated
	 */
	EAttribute getEquipamento_IsDisponivel();

	/**
	 * Returns the meta object for class '{@link sistema_emprestimo.Emprestimo <em>Emprestimo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Emprestimo</em>'.
	 * @see sistema_emprestimo.Emprestimo
	 * @model instanceClass="sistema_emprestimo.Emprestimo"
	 * @generated
	 */
	EClass getEmprestimo();

	/**
	 * Returns the meta object for the attribute '{@link sistema_emprestimo.Emprestimo#getDataRetirada <em>Data Retirada</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Retirada</em>'.
	 * @see sistema_emprestimo.Emprestimo#getDataRetirada()
	 * @see #getEmprestimo()
	 * @generated
	 */
	EAttribute getEmprestimo_DataRetirada();

	/**
	 * Returns the meta object for the attribute '{@link sistema_emprestimo.Emprestimo#getDataDevolucaoPrevista <em>Data Devolucao Prevista</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Devolucao Prevista</em>'.
	 * @see sistema_emprestimo.Emprestimo#getDataDevolucaoPrevista()
	 * @see #getEmprestimo()
	 * @generated
	 */
	EAttribute getEmprestimo_DataDevolucaoPrevista();

	/**
	 * Returns the meta object for the reference '{@link sistema_emprestimo.Emprestimo#getEquipamentoEmprestado <em>Equipamento Emprestado</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Equipamento Emprestado</em>'.
	 * @see sistema_emprestimo.Emprestimo#getEquipamentoEmprestado()
	 * @see #getEmprestimo()
	 * @generated
	 */
	EReference getEmprestimo_EquipamentoEmprestado();

	/**
	 * Returns the meta object for the reference '{@link sistema_emprestimo.Emprestimo#getProfessorResponsavel <em>Professor Responsavel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Professor Responsavel</em>'.
	 * @see sistema_emprestimo.Emprestimo#getProfessorResponsavel()
	 * @see #getEmprestimo()
	 * @generated
	 */
	EReference getEmprestimo_ProfessorResponsavel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Sistema_emprestimoFactory getSistema_emprestimoFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link sistema_emprestimo.impl.ProfessorImpl <em>Professor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sistema_emprestimo.impl.ProfessorImpl
		 * @see sistema_emprestimo.impl.Sistema_emprestimoPackageImpl#getProfessor()
		 * @generated
		 */
		EClass PROFESSOR = eINSTANCE.getProfessor();

		/**
		 * The meta object literal for the '<em><b>Nome</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFESSOR__NOME = eINSTANCE.getProfessor_Nome();

		/**
		 * The meta object literal for the '<em><b>Matricula</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFESSOR__MATRICULA = eINSTANCE.getProfessor_Matricula();

		/**
		 * The meta object literal for the '<em><b>Departamento</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFESSOR__DEPARTAMENTO = eINSTANCE.getProfessor_Departamento();

		/**
		 * The meta object literal for the '{@link sistema_emprestimo.impl.EquipamentoImpl <em>Equipamento</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sistema_emprestimo.impl.EquipamentoImpl
		 * @see sistema_emprestimo.impl.Sistema_emprestimoPackageImpl#getEquipamento()
		 * @generated
		 */
		EClass EQUIPAMENTO = eINSTANCE.getEquipamento();

		/**
		 * The meta object literal for the '<em><b>Nome</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIPAMENTO__NOME = eINSTANCE.getEquipamento_Nome();

		/**
		 * The meta object literal for the '<em><b>Codigo Tombamento</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIPAMENTO__CODIGO_TOMBAMENTO = eINSTANCE.getEquipamento_CodigoTombamento();

		/**
		 * The meta object literal for the '<em><b>Is Disponivel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUIPAMENTO__IS_DISPONIVEL = eINSTANCE.getEquipamento_IsDisponivel();

		/**
		 * The meta object literal for the '{@link sistema_emprestimo.impl.EmprestimoImpl <em>Emprestimo</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sistema_emprestimo.impl.EmprestimoImpl
		 * @see sistema_emprestimo.impl.Sistema_emprestimoPackageImpl#getEmprestimo()
		 * @generated
		 */
		EClass EMPRESTIMO = eINSTANCE.getEmprestimo();

		/**
		 * The meta object literal for the '<em><b>Data Retirada</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPRESTIMO__DATA_RETIRADA = eINSTANCE.getEmprestimo_DataRetirada();

		/**
		 * The meta object literal for the '<em><b>Data Devolucao Prevista</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPRESTIMO__DATA_DEVOLUCAO_PREVISTA = eINSTANCE.getEmprestimo_DataDevolucaoPrevista();

		/**
		 * The meta object literal for the '<em><b>Equipamento Emprestado</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMPRESTIMO__EQUIPAMENTO_EMPRESTADO = eINSTANCE.getEmprestimo_EquipamentoEmprestado();

		/**
		 * The meta object literal for the '<em><b>Professor Responsavel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMPRESTIMO__PROFESSOR_RESPONSAVEL = eINSTANCE.getEmprestimo_ProfessorResponsavel();

	}

} //Sistema_emprestimoPackage
