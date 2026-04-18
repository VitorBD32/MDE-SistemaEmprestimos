/**
 */
package sistema_emprestimo.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import sistema_emprestimo.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Sistema_emprestimoFactoryImpl extends EFactoryImpl implements Sistema_emprestimoFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Sistema_emprestimoFactory init() {
		try {
			Sistema_emprestimoFactory theSistema_emprestimoFactory = (Sistema_emprestimoFactory)EPackage.Registry.INSTANCE.getEFactory(Sistema_emprestimoPackage.eNS_URI);
			if (theSistema_emprestimoFactory != null) {
				return theSistema_emprestimoFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Sistema_emprestimoFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sistema_emprestimoFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Sistema_emprestimoPackage.PROFESSOR: return createProfessor();
			case Sistema_emprestimoPackage.EQUIPAMENTO: return createEquipamento();
			case Sistema_emprestimoPackage.EMPRESTIMO: return (EObject)createEmprestimo();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Professor createProfessor() {
		ProfessorImpl professor = new ProfessorImpl();
		return professor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Equipamento createEquipamento() {
		EquipamentoImpl equipamento = new EquipamentoImpl();
		return equipamento;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Emprestimo createEmprestimo() {
		EmprestimoImpl emprestimo = new EmprestimoImpl();
		return emprestimo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Sistema_emprestimoPackage getSistema_emprestimoPackage() {
		return (Sistema_emprestimoPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Sistema_emprestimoPackage getPackage() {
		return Sistema_emprestimoPackage.eINSTANCE;
	}

} //Sistema_emprestimoFactoryImpl
