package br.com.morpheos.dao.common;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.morpheos.dao.impl.AdesaoMedicacaoDao;
import br.com.morpheos.dao.impl.AdesaoTratamentoDao;
import br.com.morpheos.dao.impl.BioquimicaDao;
import br.com.morpheos.dao.impl.DoencaEventoDao;
import br.com.morpheos.dao.impl.EcocardiogramaDao;
import br.com.morpheos.dao.impl.EventoAdversoDao;
import br.com.morpheos.dao.impl.RelatorioExcelDao;
import br.com.morpheos.dao.impl.GrpMedicamentoDao;
import br.com.morpheos.dao.impl.LogAuditoriaVisitaDao;
import br.com.morpheos.dao.impl.MedicamentoDao;
import br.com.morpheos.dao.impl.MedicamentoUsoDao;
import br.com.morpheos.dao.impl.PacienteDao;
import br.com.morpheos.dao.impl.PoligrafiaDao;
import br.com.morpheos.dao.impl.PolissonografiaDao;
import br.com.morpheos.dao.impl.PressaoArterialDao;
import br.com.morpheos.dao.impl.QuestionarioAplicacaoDao;
import br.com.morpheos.dao.impl.QuestionarioBerlimDao;
import br.com.morpheos.dao.impl.QuestionarioCageDao;
import br.com.morpheos.dao.impl.QuestionarioInternacionalDao;
import br.com.morpheos.dao.impl.QuestionarioMapaDao;
import br.com.morpheos.dao.impl.SaidaEstudoDao;
import br.com.morpheos.dao.impl.SphygmocorDao;
import br.com.morpheos.dao.impl.UnidadeAtendimentoDao;
import br.com.morpheos.dao.impl.UsuarioDao;
import br.com.morpheos.dao.impl.Visita00Dao;
import br.com.morpheos.dao.impl.Visita01Dao;
import br.com.morpheos.dao.impl.Visita02Dao;
import br.com.morpheos.dao.impl.Visita03Dao;
import br.com.morpheos.dao.impl.Visita04Dao;
import br.com.morpheos.dao.impl.Visita05Dao;
import br.com.morpheos.dao.impl.Visita06Dao;
import br.com.morpheos.dao.impl.Visita07Dao;
import br.com.morpheos.dao.impl.Visita08Dao;
import br.com.morpheos.dao.impl.Visita09Dao;
import br.com.morpheos.dao.impl.Visita10Dao;
import br.com.morpheos.dao.impl.Visita11Dao;
import br.com.morpheos.dao.impl.Visita12Dao;
import br.com.morpheos.dao.impl.Visita13Dao;
import br.com.morpheos.dao.impl.Visita14Dao;
import br.com.morpheos.dao.impl.Visita15Dao;
import br.com.morpheos.dao.impl.Visita16Dao;
import br.com.morpheos.dao.impl.Visita17Dao;
import br.com.morpheos.dao.impl.VisitaDao;
import br.com.morpheos.util.HibernateUtil;

public class FactoryDao {

	private Session session;
    private Transaction transaction;  
      
      
    public FactoryDao(){
    	session =  HibernateUtil.currentSession();
    }  
	
	public void beginTransaction(){
		this.transaction = this.session.beginTransaction();
	}
	
	public void commit(){
		this.transaction.commit();
		this.transaction = null;
	}
	
	public boolean hasTransaction(){
		return this.transaction != null;
	}
	
	public void rollback(){
		this.transaction.rollback();
		this.transaction = null;
	}
	
	@SuppressWarnings("deprecation")
	public void close(){
		try {
			this.session.connection().close();
		} catch (HibernateException e) {
			System.out.println("Erro ao fechar conexão com o BD: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Erro ao fechar conexão com o BD: " + e.getMessage());
		}
		this.session.close();
	}
	
	
	public void clear(){
		this.session.clear();
	}
	
	/*
	 * Modelos
	 * 
	 */
	public UnidadeAtendimentoDao getUnidadeDao(){
		return new UnidadeAtendimentoDao(this.session);
	}
	
	public UsuarioDao getUsuarioDao(){
		return new UsuarioDao(this.session);
	}
	
	public DoencaEventoDao getDoencaEventoDao(){
		return new DoencaEventoDao(this.session);
	}
	
	public GrpMedicamentoDao getGrpMedicamentoDao(){
		return new GrpMedicamentoDao(this.session);
	}
	
	public MedicamentoDao getMedicamentoDao(){
		return new MedicamentoDao(this.session);
	}
	
	public LogAuditoriaVisitaDao getLogAuditoriaVisitaDao(){
		return new LogAuditoriaVisitaDao(this.session);
	}
	
	public PacienteDao getPacienteDao(){
		return new PacienteDao(this.session);
	}
	
	public VisitaDao getVisitaDao(){
		return new VisitaDao(this.session);
	}
	
	public Visita00Dao getVisita00Dao(){
		return new Visita00Dao(this.session);
	}
	
	public Visita01Dao getVisita01Dao(){
		return new Visita01Dao(this.session);
	}
	
	public Visita02Dao getVisita02Dao(){
		return new Visita02Dao(this.session);
	}
	
	public Visita03Dao getVisita03Dao(){
		return new Visita03Dao(this.session);
	}
	
	public Visita04Dao getVisita04Dao(){
		return new Visita04Dao(this.session);
	}
	
	public Visita05Dao getVisita05Dao(){
		return new Visita05Dao(this.session);
	}
	
	public Visita06Dao getVisita06Dao(){
		return new Visita06Dao(this.session);
	}
	
	public Visita07Dao getVisita07Dao(){
		return new Visita07Dao(this.session);
	}
	
	public Visita08Dao getVisita08Dao(){
		return new Visita08Dao(this.session);
	}
	
	public Visita09Dao getVisita09Dao(){
		return new Visita09Dao(this.session);
	}
	
	public Visita10Dao getVisita10Dao(){
		return new Visita10Dao(this.session);
	}
	
	public Visita11Dao getVisita11Dao(){
		return new Visita11Dao(this.session);
	}
	
	public Visita12Dao getVisita12Dao(){
		return new Visita12Dao(this.session);
	}
	
	public Visita13Dao getVisita13Dao(){
		return new Visita13Dao(this.session);
	}
	
	public Visita14Dao getVisita14Dao(){
		return new Visita14Dao(this.session);
	}
	
	public Visita15Dao getVisita15Dao(){
		return new Visita15Dao(this.session);
	}
	
	public Visita16Dao getVisita16Dao(){
		return new Visita16Dao(this.session);
	}
	
	public Visita17Dao getVisita17Dao(){
		return new Visita17Dao(this.session);
	}
	
	public QuestionarioAplicacaoDao getQuestionarioAplicacaoDao(){
		return new QuestionarioAplicacaoDao(this.session);
	}
	
	public QuestionarioInternacionalDao getQuestionarioInternacionalDao(){
		return new QuestionarioInternacionalDao(this.session);
	}
	
	public QuestionarioMapaDao getQuestionarioMapaDao(){
		return new QuestionarioMapaDao(this.session);
	}
	
	public SphygmocorDao getSphygmocorDao(){
		return new SphygmocorDao(this.session);
	}
	
	public MedicamentoUsoDao getMedicamentoUsoDao(){
		return new MedicamentoUsoDao(this.session);
	}
	
	public PoligrafiaDao getPoligrafiaDao(){
		return new PoligrafiaDao(this.session);
	}
	
	public PolissonografiaDao getPolissonografiaDao(){
		return new PolissonografiaDao(this.session);
	}
	
	public PressaoArterialDao getPressaoArterialDao(){
		return new PressaoArterialDao(this.session);
	}
	
	public QuestionarioBerlimDao getQuestionarioBerlimDao(){
		return new QuestionarioBerlimDao(this.session);
	}
	
	public QuestionarioCageDao getQuestionarioCageDao(){
		return new QuestionarioCageDao(this.session);
	}
	
	public EventoAdversoDao getEventoAdversoDao(){
		return new EventoAdversoDao(this.session);
	}
	
	public SaidaEstudoDao getSaidaEstudoDao(){
		return new SaidaEstudoDao(this.session);
	}
	
	public BioquimicaDao getBioquimicaDao(){
		return new BioquimicaDao(this.session);
	}
	
	public EcocardiogramaDao getEcocardiogramaDao(){
		return new EcocardiogramaDao(this.session);
	}
	
	public AdesaoTratamentoDao getAdesaoTratamentoDao(){
		return new AdesaoTratamentoDao(this.session);
	}
	
	public AdesaoMedicacaoDao getAdesaoMedicacaoDao(){
		return new AdesaoMedicacaoDao(this.session);
	}
	
	public RelatorioExcelDao getFRelatorioExcelDao(){
		return new RelatorioExcelDao(this.session);
	}

}
