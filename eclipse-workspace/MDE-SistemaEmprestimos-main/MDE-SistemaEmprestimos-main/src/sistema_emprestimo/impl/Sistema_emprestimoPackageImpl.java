/**
 */
package sistema_emprestimo.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import sistema_emprestimo.Emprestimo;
import sistema_emprestimo.Equipamento;
import sistema_emprestimo.Professor;
import sistema_emprestimo.Sistema_emprestimoFactory;
import sistema_emprestimo.Sistema_emprestimoPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Sistema_emprestimoPackageImpl extends EPackageImpl implements Sistema_emprestimoPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass professorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equipamentoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emprestimoEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see sistema_emprestimo.Sistema_emprestimoPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Sistema_emprestimoPackageImpl() {
		super(eNS_URI, Sistema_emprestimoFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link Sistema_emprestimoPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Sistema_emprestimoPackage init() {
		if (isInited) return (Sistema_emprestimoPackage)EPackage.Registry.INSTANCE.getEPackage(Sistema_emprestimoPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSistema_emprestimoPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		Sistema_emprestimoPackageImpl theSistema_emprestimoPackage = registeredSistema_emprestimoPackage instanceof Sistema_emprestimoPackageImpl ? (Sistema_emprestimoPackageImpl)registeredSistema_emprestimoPackage : new Sistema_emprestimoPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theSistema_emprestimoPackage.createPackageContents();

		// Initialize created meta-data
		theSistema_emprestimoPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSistema_emprestimoPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Sistema_emprestimoPackage.eNS_URI, theSistema_emprestimoPackage);
		return theSistema_emprestimoPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProfessor() {
		return professorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProfessor_Nome() {
		return (EAttribute)professorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProfessor_Matricula() {
		return (EAttribute)professorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProfessor_Departamento() {
		return (EAttribute)professorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEquipamento() {
		return equipamentoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEquipamento_Nome() {
		return (EAttribute)equipamentoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEquipamento_CodigoTombamento() {
		return (EAttribute)equipamentoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEquipamento_IsDisponivel() {
		return (EAttribute)equipamentoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEmprestimo() {
		return emprestimoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEmprestimo_DataRetirada() {
		return (EAttribute)emprestimoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEmprestimo_DataDevolucaoPrevista() {
		return (EAttribute)emprestimoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEmprestimo_EquipamentoEmprestado() {
		return (EReference)emprestimoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEmprestimo_ProfessorResponsavel() {
		return (EReference)emprestimoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Sistema_emprestimoFactory getSistema_emprestimoFactory() {
		return (Sistema_emprestimoFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		professorEClass = createEClass(PROFESSOR);
		createEAttribute(professorEClass, PROFESSOR__NOME);
		createEAttribute(professorEClass, PROFESSOR__MATRICULA);
		createEAttribute(professorEClass, PROFESSOR__DEPARTAMENTO);

		equipamentoEClass = createEClass(EQUIPAMENTO);
		createEAttribute(equipamentoEClass, EQUIPAMENTO__NOME);
		createEAttribute(equipamentoEClass, EQUIPAMENTO__CODIGO_TOMBAMENTO);
		createEAttribute(equipamentoEClass, EQUIPAMENTO__IS_DISPONIVEL);

		emprestimoEClass = createEClass(EMPRESTIMO);
		createEAttribute(emprestimoEClass, EMPRESTIMO__DATA_RETIRADA);
		createEAttribute(emprestimoEClass, EMPRESTIMO__DATA_DEVOLUCAO_PREVISTA);
		createEReference(emprestimoEClass, EMPRESTIMO__EQUIPAMENTO_EMPRESTADO);
		createEReference(emprestimoEClass, EMPRESTIMO__PROFESSOR_RESPONSAVEL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(professorEClass, Professor.class, "Professor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProfessor_Nome(), ecorePackage.getEString(), "nome", null, 0, 1, Professor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getProfessor_Matricula(), ecorePackage.getEString(), "matricula", null, 0, 1, Professor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfessor_Departamento(), ecorePackage.getEString(), "departamento", null, 0, 1, Professor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(equipamentoEClass, Equipamento.class, "Equipamento", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEquipamento_Nome(), ecorePackage.getEString(), "nome", null, 0, 1, Equipamento.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquipamento_CodigoTombamento(), ecorePackage.getEInt(), "codigoTombamento", null, 0, 1, Equipamento.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquipamento_IsDisponivel(), ecorePackage.getEBoolean(), "isDisponivel", null, 0, 1, Equipamento.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(emprestimoEClass, Emprestimo.class, "Emprestimo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEmprestimo_DataRetirada(), ecorePackage.getEDate(), "dataRetirada", null, 0, 1, Emprestimo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEmprestimo_DataDevolucaoPrevista(), ecorePackage.getEDate(), "dataDevolucaoPrevista", null, 0, 1, Emprestimo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEmprestimo_EquipamentoEmprestado(), this.getEquipamento(), null, "equipamentoEmprestado", null, 0, 1, Emprestimo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEmprestimo_ProfessorResponsavel(), this.getEquipamento(), null, "professorResponsavel", null, 0, 1, Emprestimo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Sistema_emprestimoPackageImpl
