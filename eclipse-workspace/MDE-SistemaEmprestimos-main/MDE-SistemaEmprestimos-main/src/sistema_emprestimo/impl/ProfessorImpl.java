/**
 */
package sistema_emprestimo.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import sistema_emprestimo.Professor;
import sistema_emprestimo.Sistema_emprestimoPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Professor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link sistema_emprestimo.impl.ProfessorImpl#getNome <em>Nome</em>}</li>
 *   <li>{@link sistema_emprestimo.impl.ProfessorImpl#getMatricula <em>Matricula</em>}</li>
 *   <li>{@link sistema_emprestimo.impl.ProfessorImpl#getDepartamento <em>Departamento</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProfessorImpl extends MinimalEObjectImpl.Container implements Professor {
	/**
	 * The default value of the '{@link #getNome() <em>Nome</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNome()
	 * @generated
	 * @ordered
	 */
	protected static final String NOME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNome() <em>Nome</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNome()
	 * @generated
	 * @ordered
	 */
	protected String nome = NOME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMatricula() <em>Matricula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatricula()
	 * @generated
	 * @ordered
	 */
	protected static final String MATRICULA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMatricula() <em>Matricula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatricula()
	 * @generated
	 * @ordered
	 */
	protected String matricula = MATRICULA_EDEFAULT;

	/**
	 * The default value of the '{@link #getDepartamento() <em>Departamento</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartamento()
	 * @generated
	 * @ordered
	 */
	protected static final String DEPARTAMENTO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDepartamento() <em>Departamento</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartamento()
	 * @generated
	 * @ordered
	 */
	protected String departamento = DEPARTAMENTO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProfessorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Sistema_emprestimoPackage.Literals.PROFESSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNome() {
		return nome;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNome(String newNome) {
		String oldNome = nome;
		nome = newNome;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sistema_emprestimoPackage.PROFESSOR__NOME, oldNome, nome));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMatricula() {
		return matricula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMatricula(String newMatricula) {
		String oldMatricula = matricula;
		matricula = newMatricula;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sistema_emprestimoPackage.PROFESSOR__MATRICULA, oldMatricula, matricula));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDepartamento() {
		return departamento;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepartamento(String newDepartamento) {
		String oldDepartamento = departamento;
		departamento = newDepartamento;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sistema_emprestimoPackage.PROFESSOR__DEPARTAMENTO, oldDepartamento, departamento));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Sistema_emprestimoPackage.PROFESSOR__NOME:
				return getNome();
			case Sistema_emprestimoPackage.PROFESSOR__MATRICULA:
				return getMatricula();
			case Sistema_emprestimoPackage.PROFESSOR__DEPARTAMENTO:
				return getDepartamento();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Sistema_emprestimoPackage.PROFESSOR__NOME:
				setNome((String)newValue);
				return;
			case Sistema_emprestimoPackage.PROFESSOR__MATRICULA:
				setMatricula((String)newValue);
				return;
			case Sistema_emprestimoPackage.PROFESSOR__DEPARTAMENTO:
				setDepartamento((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Sistema_emprestimoPackage.PROFESSOR__NOME:
				setNome(NOME_EDEFAULT);
				return;
			case Sistema_emprestimoPackage.PROFESSOR__MATRICULA:
				setMatricula(MATRICULA_EDEFAULT);
				return;
			case Sistema_emprestimoPackage.PROFESSOR__DEPARTAMENTO:
				setDepartamento(DEPARTAMENTO_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Sistema_emprestimoPackage.PROFESSOR__NOME:
				return NOME_EDEFAULT == null ? nome != null : !NOME_EDEFAULT.equals(nome);
			case Sistema_emprestimoPackage.PROFESSOR__MATRICULA:
				return MATRICULA_EDEFAULT == null ? matricula != null : !MATRICULA_EDEFAULT.equals(matricula);
			case Sistema_emprestimoPackage.PROFESSOR__DEPARTAMENTO:
				return DEPARTAMENTO_EDEFAULT == null ? departamento != null : !DEPARTAMENTO_EDEFAULT.equals(departamento);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (nome: ");
		result.append(nome);
		result.append(", matricula: ");
		result.append(matricula);
		result.append(", departamento: ");
		result.append(departamento);
		result.append(')');
		return result.toString();
	}

} //ProfessorImpl
