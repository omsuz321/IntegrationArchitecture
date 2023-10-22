package de.hbrs.ia.code;
import java.util.List;

import de.hbrs.ia.model.SalesMan;



/**
 * Code lines are commented for suppressing compile errors.
 */
public interface ManagePersonal {

    public void createSalesMan( SalesMan record );

    //public void addPerformanceReord( EvaluationRecord record , int sid );

    public SalesMan readSalesMan( int sid );

    public List<SalesMan> querySalesMan(String attribute , String key );

    //public EvaluationRecord readEvaluationRecords( int sid );

}
