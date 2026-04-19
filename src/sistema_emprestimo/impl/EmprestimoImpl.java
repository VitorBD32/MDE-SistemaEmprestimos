/**
 */
package sistema_emprestimo.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import sistema_emprestimo.Emprestimo;
import sistema_emprestimo.Equipamento;
import sistema_emprestimo.Professor;
import sistema_emprestimo.Sistema_emprestimoPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Emprestimo</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link sistema_emprestimo.impl.EmprestimoImpl#getDataRetirada <em>Data Retirada</em>}</li>
 *   <li>{@link sistema_emprestimo.impl.EmprestimoImpl#getDataDevolucaoPrevista <em>Data Devolucao Prevista</em>}</li>
 *   <li>{@link sistema_emprestimo.impl.EmprestimoImpl#getEquipamentoEmprestado <em>Equipamento Emprestado</em>}</li>
 *   <li>{@link sistema_emprestimo.impl.EmprestimoImpl#getProfessorResponsavel <em>Professor Responsavel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EmprestimoImpl extends MinimalEObjectImpl.Container implements Emprestimo {
	/**
	 * The default value of the '{@link #getDataRetirada() <em>Data Retirada</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataRetirada()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATA_RETIRADA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataRetirada() <em>Data Retirada</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataRetirada()
	 * @generated
	 * @ordered
	 */
	protected Date dataRetirada = DATA_RETIRADA_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataDevolucaoPrevista() <em>Data Devolucao Prevista</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataDevolucaoPrevista()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATA_DEVOLUCAO_PREVISTA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataDevolucaoPrevista() <em>Data Devolucao Prevista</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataDevolucaoPrevista()
	 * @generated
	 * @ordered
	 */
	protected Date dataDevolucaoPrevista = DATA_DEVOLUCAO_PREVISTA_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEquipamentoEmprestado() <em>Equipamento Emprestado</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipamentoEmprestado()
	 * @generated
	 * @ordered
	 */
	protected Equipamento equipamentoEmprestado;

	/**
	 * The cached value of the '{@link #getProfessorResponsavel() <em>Professor Responsavel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfessorResponsavel()
	 * @generated
	 * @ordered
	 */
	protected Professor professorResponsavel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmprestimoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Sistema_emprestimoPackage.Literals.EMPRESTIMO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getDataRetirada() {
		return dataRetirada;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataRetirada(Date newDataRetirada) {
		Date oldDataRetirada = dataRetirada;
		dataRetirada = newDataRetirada;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sistema_emprestimoPackage.EMPRESTIMO__DATA_RETIRADA, oldDataRetirada, dataRetirada));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataDevolucaoPrevista(Date newDataDevolucaoPrevista) {
		Date oldDataDevolucaoPrevista = dataDevolucaoPrevista;
		dataDevolucaoPrevista = newDataDevolucaoPrevista;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sistema_emprestimoPackage.EMPRESTIMO__DATA_DEVOLUCAO_PREVISTA, oldDataDevolucaoPrevista, dataDevolucaoPrevista));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Equipamento getEquipamentoEmprestado() {
		if (equipamentoEmprestado != null && equipamentoEmprestado.eIsProxy()) {
			InternalEObject oldEquipamentoEmprestado = (InternalEObject)equipamentoEmprestado;
			equipamentoEmprestado = (Equipamento)eResolveProxy(oldEquipamentoEmprestado);
			if (equipamentoEmprestado != oldEquipamentoEmprestado) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sistema_emprestimoPackage.EMPRESTIMO__EQUIPAMENTO_EMPRESTADO, oldEquipamentoEmprestado, equipamentoEmprestado));
			}
		}
		return equipamentoEmprestado;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equipamento basicGetEquipamentoEmprestado() {
		return equipamentoEmprestado;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEquipamentoEmprestado(Equipamento newEquipamentoEmprestado) {
		Equipamento oldEquipamentoEmprestado = equipamentoEmprestado;
		equipamentoEmprestado = newEquipamentoEmprestado;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sistema_emprestimoPackage.EMPRESTIMO__EQUIPAMENTO_EMPRESTADO, oldEquipamentoEmprestado, equipamentoEmprestado));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Equipamento getProfessorResponsavel() {
		if (professorResponsavel != null && professorResponsavel.eIsProxy()) {
			InternalEObject oldProfessorResponsavel = (InternalEObject)professorResponsavel;
			professorResponsavel = (Professor)eResolveProxy(oldProfessorResponsavel);
			if (professorResponsavel != oldProfessorResponsavel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sistema_emprestimoPackage.EMPRESTIMO__PROFESSOR_RESPONSAVEL, oldProfessorResponsavel, professorResponsavel));
			}
		}
		return (Equipamento) professorResponsavel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Professor basicGetProfessorResponsavel() {
		return professorResponsavel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProfessorResponsavel(Professor newProfessorResponsavel) {
		Professor oldProfessorResponsavel = professorResponsavel;
		professorResponsavel = newProfessorResponsavel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sistema_emprestimoPackage.EMPRESTIMO__PROFESSOR_RESPONSAVEL, oldProfessorResponsavel, professorResponsavel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Sistema_emprestimoPackage.EMPRESTIMO__DATA_RETIRADA:
				return getDataRetirada();
			case Sistema_emprestimoPackage.EMPRESTIMO__DATA_DEVOLUCAO_PREVISTA:
				return getDataDevolucaoPrevista();
			case Sistema_emprestimoPackage.EMPRESTIMO__EQUIPAMENTO_EMPRESTADO:
				if (resolve) return getEquipamentoEmprestado();
				return basicGetEquipamentoEmprestado();
			case Sistema_emprestimoPackage.EMPRESTIMO__PROFESSOR_RESPONSAVEL:
				if (resolve) return getProfessorResponsavel();
				return basicGetProfessorResponsavel();
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
			case Sistema_emprestimoPackage.EMPRESTIMO__DATA_RETIRADA:
				setDataRetirada((Date)newValue);
				return;
			case Sistema_emprestimoPackage.EMPRESTIMO__DATA_DEVOLUCAO_PREVISTA:
				setDataDevolucaoPrevista((Date)newValue);
				return;
			case Sistema_emprestimoPackage.EMPRESTIMO__EQUIPAMENTO_EMPRESTADO:
				setEquipamentoEmprestado((Equipamento)newValue);
				return;
			case Sistema_emprestimoPackage.EMPRESTIMO__PROFESSOR_RESPONSAVEL:
				setProfessorResponsavel((Professor)newValue);
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
			case Sistema_emprestimoPackage.EMPRESTIMO__DATA_RETIRADA:
				setDataRetirada(DATA_RETIRADA_EDEFAULT);
				return;
			case Sistema_emprestimoPackage.EMPRESTIMO__DATA_DEVOLUCAO_PREVISTA:
				setDataDevolucaoPrevista(DATA_DEVOLUCAO_PREVISTA_EDEFAULT);
				return;
			case Sistema_emprestimoPackage.EMPRESTIMO__EQUIPAMENTO_EMPRESTADO:
				setEquipamentoEmprestado((Equipamento)null);
				return;
			case Sistema_emprestimoPackage.EMPRESTIMO__PROFESSOR_RESPONSAVEL:
				setProfessorResponsavel((Professor)null);
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
			case Sistema_emprestimoPackage.EMPRESTIMO__DATA_RETIRADA:
				return DATA_RETIRADA_EDEFAULT == null ? dataRetirada != null : !DATA_RETIRADA_EDEFAULT.equals(dataRetirada);
			case Sistema_emprestimoPackage.EMPRESTIMO__DATA_DEVOLUCAO_PREVISTA:
				return DATA_DEVOLUCAO_PREVISTA_EDEFAULT == null ? dataDevolucaoPrevista != null : !DATA_DEVOLUCAO_PREVISTA_EDEFAULT.equals(dataDevolucaoPrevista);
			case Sistema_emprestimoPackage.EMPRESTIMO__EQUIPAMENTO_EMPRESTADO:
				return equipamentoEmprestado != null;
			case Sistema_emprestimoPackage.EMPRESTIMO__PROFESSOR_RESPONSAVEL:
				return professorResponsavel != null;
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
		result.append(" (dataRetirada: ");
		result.append(dataRetirada);
		result.append(", dataDevolucaoPrevista: ");
		result.append(dataDevolucaoPrevista);
		result.append(')');
		return result.toString();
	}

} //EmprestimoImpl
