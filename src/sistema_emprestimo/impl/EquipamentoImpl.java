/**
 */
package sistema_emprestimo.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import sistema_emprestimo.Equipamento;
import sistema_emprestimo.Sistema_emprestimoPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equipamento</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link sistema_emprestimo.impl.EquipamentoImpl#getNome <em>Nome</em>}</li>
 *   <li>{@link sistema_emprestimo.impl.EquipamentoImpl#getCodigoTombamento <em>Codigo Tombamento</em>}</li>
 *   <li>{@link sistema_emprestimo.impl.EquipamentoImpl#isIsDisponivel <em>Is Disponivel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EquipamentoImpl extends MinimalEObjectImpl.Container implements Equipamento {
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
	 * The default value of the '{@link #getCodigoTombamento() <em>Codigo Tombamento</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodigoTombamento()
	 * @generated
	 * @ordered
	 */
	protected static final int CODIGO_TOMBAMENTO_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCodigoTombamento() <em>Codigo Tombamento</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodigoTombamento()
	 * @generated
	 * @ordered
	 */
	protected int codigoTombamento = CODIGO_TOMBAMENTO_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsDisponivel() <em>Is Disponivel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDisponivel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DISPONIVEL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDisponivel() <em>Is Disponivel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDisponivel()
	 * @generated
	 * @ordered
	 */
	protected boolean isDisponivel = IS_DISPONIVEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquipamentoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Sistema_emprestimoPackage.Literals.EQUIPAMENTO;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Sistema_emprestimoPackage.EQUIPAMENTO__NOME, oldNome, nome));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCodigoTombamento() {
		return codigoTombamento;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCodigoTombamento(int newCodigoTombamento) {
		int oldCodigoTombamento = codigoTombamento;
		codigoTombamento = newCodigoTombamento;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sistema_emprestimoPackage.EQUIPAMENTO__CODIGO_TOMBAMENTO, oldCodigoTombamento, codigoTombamento));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsDisponivel() {
		return isDisponivel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsDisponivel(boolean newIsDisponivel) {
		boolean oldIsDisponivel = isDisponivel;
		isDisponivel = newIsDisponivel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sistema_emprestimoPackage.EQUIPAMENTO__IS_DISPONIVEL, oldIsDisponivel, isDisponivel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Sistema_emprestimoPackage.EQUIPAMENTO__NOME:
				return getNome();
			case Sistema_emprestimoPackage.EQUIPAMENTO__CODIGO_TOMBAMENTO:
				return getCodigoTombamento();
			case Sistema_emprestimoPackage.EQUIPAMENTO__IS_DISPONIVEL:
				return isIsDisponivel();
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
			case Sistema_emprestimoPackage.EQUIPAMENTO__NOME:
				setNome((String)newValue);
				return;
			case Sistema_emprestimoPackage.EQUIPAMENTO__CODIGO_TOMBAMENTO:
				setCodigoTombamento((Integer)newValue);
				return;
			case Sistema_emprestimoPackage.EQUIPAMENTO__IS_DISPONIVEL:
				setIsDisponivel((Boolean)newValue);
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
			case Sistema_emprestimoPackage.EQUIPAMENTO__NOME:
				setNome(NOME_EDEFAULT);
				return;
			case Sistema_emprestimoPackage.EQUIPAMENTO__CODIGO_TOMBAMENTO:
				setCodigoTombamento(CODIGO_TOMBAMENTO_EDEFAULT);
				return;
			case Sistema_emprestimoPackage.EQUIPAMENTO__IS_DISPONIVEL:
				setIsDisponivel(IS_DISPONIVEL_EDEFAULT);
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
			case Sistema_emprestimoPackage.EQUIPAMENTO__NOME:
				return NOME_EDEFAULT == null ? nome != null : !NOME_EDEFAULT.equals(nome);
			case Sistema_emprestimoPackage.EQUIPAMENTO__CODIGO_TOMBAMENTO:
				return codigoTombamento != CODIGO_TOMBAMENTO_EDEFAULT;
			case Sistema_emprestimoPackage.EQUIPAMENTO__IS_DISPONIVEL:
				return isDisponivel != IS_DISPONIVEL_EDEFAULT;
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
		result.append(", codigoTombamento: ");
		result.append(codigoTombamento);
		result.append(", isDisponivel: ");
		result.append(isDisponivel);
		result.append(')');
		return result.toString();
	}

} //EquipamentoImpl
