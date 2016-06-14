package org.hodgson.marklogic;

import com.marklogic.xcc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static org.hodgson.marklogic.Cleardown.*;

/**
 * Description:
 *
 * @author <a href="ralph.hodgson@pressassociation.com">Ralph Hodgson</a>
 * @since 2016-05-06T12:11
 */
public class TaskRunner {

	protected static final Logger LOG = LoggerFactory.getLogger(TaskRunner.class);

	private static final List<String> statements = Arrays.asList(
		ODF_BODY, ODF_CUMULATIVE_RESULT, ODF_EVENT_REGISTRATION, ODF_MEDAL, ODF_RECORD, ODF_SCHEDULES, ODF_TEAM_PARTICS, ODF_STATUS, PA_LOG
	);

	public static void main(String[] args) throws Exception {

		ResourceBundle rb  = ResourceBundle.getBundle("application");

		String competition = rb.getString("param.competition");
		String discipline  = rb.getString("param.discipline");

		URI uri = new URI(rb.getString("xcc.connection"));

		LOG.info("Connecting to : {}", uri);

		ContentSource contentSource =	ContentSourceFactory.newContentSource (uri);

		Session session = contentSource.newSession();

		LOG.info("Discipline = {}, Competition = {}", discipline, competition);

		LOG.info("Executing. Please wait...");

		for(String statement : statements){
			String query = statement.replace("@@DISCIPLINE", discipline).replace("@@COMPETITION", competition);

			Request request = session.newAdhocQuery (query);

			ResultSequence rs = session.submitRequest (request);

			LOG.info("Query Completed : {} ", rs.toString());
		}
		LOG.info("Command selection all done");

		session.close();
	}


}
