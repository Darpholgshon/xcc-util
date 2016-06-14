package org.hodgson.marklogic;

/**
 * Description:
 *
 * @author <a href="ralph.hodgson@pressassociation.com">Ralph Hodgson</a>
 * @since 2016-06-14T11:51
 */
public class Cleardown {

	public static final String ODF_BODY =
		"xquery version '1.0-ml'; " +
		" " +
		"  for $doc in /OdfBody[@competition = '@@COMPETITION' and fn:starts-with(@eventId, '@@DISCIPLINE')]" +
		"  return" +
		"    try{ xdmp:document-delete(xdmp:node-uri($doc)) } catch ($e){()}";

	public static final String ODF_SCHEDULES =
		"xquery version '1.0-ml'; " +
		" " +
		"  for $doc in /OdfScheduledEvent[@competition = '@@COMPETITION' and fn:starts-with(@eventId, '@@DISCIPLINE')]" +
		"  return" +
	  "    try{ xdmp:document-delete(xdmp:node-uri($doc)) } catch ($e){()}";

	public static final String ODF_MEDAL =
		"xquery version '1.0-ml'; " +
		" " +
		"  for $doc in /OdfMedal[@competition = '@@COMPETITION' and @discipline = '@@DISCIPLINE']" +
		"  return" +
		"    try{ xdmp:document-delete(xdmp:node-uri($doc)) } catch ($e){()}";

	public static final String ODF_RECORD =
		"xquery version '1.0-ml'; " +
		" " +
		"  for $doc in /OdfRecord[@competition = '@@COMPETITION' and @disciplineCode = '@@DISCIPLINE']" +
		"  return" +
		"    try{ xdmp:document-delete(xdmp:node-uri($doc)) } catch ($e){()}";

	public static final String ODF_CUMULATIVE_RESULT =
		"xquery version '1.0-ml'; " +
		" " +
		"  for $doc in /OdfRecord[@competition = '@@COMPETITION' and fn:starts-with(@eventId, '@@DISCIPLINE')]" +
		"  return" +
		"    try{ xdmp:document-delete(xdmp:node-uri($doc)) } catch ($e){()}";

	public static final String ODF_EVENT_REGISTRATION =
		"xquery version '1.0-ml'; " +
		" " +
		"  for $doc in /OdfEventRegistration[@competition = '@@COMPETITION' and @disciplineCode = '@@DISCIPLINE']" +
		"  return" +
		"    try{ xdmp:document-delete(xdmp:node-uri($doc)) } catch ($e){()}";

	public static final String ODF_TEAM_PARTICS =
		"xquery version '1.0-ml'; " +
		" " +
		"  for $doc in /OdfTeamParticipant[@competition = '@@COMPETITION' and @disciplineCode = '@@DISCIPLINE']" +
		"  return" +
		"    try{ xdmp:document-delete(xdmp:node-uri($doc)) } catch ($e){()}";

	public static final String ODF_START_LIST =
		"xquery version '1.0-ml'; " +
		" " +
		"  for $doc in /OdfStartList[@competition = '@@COMPETITION' and fn:starts-with(@unitId, '@@DISCIPLINE')]" +
		"  return" +
		"    try{ xdmp:document-delete(xdmp:node-uri($doc)) } catch ($e){()}";

	public static final String ODF_STATUS =
		"xquery version '1.0-ml'; " +
			" " +
			"  for $doc in /OdfEventRegistration[@competition = '@@COMPETITION' and @disciplineCode = '@@DISCIPLINE']" +
			"  return" +
			"    try{ xdmp:document-delete(xdmp:node-uri($doc)) } catch ($e){()}";

	public static final String PA_LOG =
		"xquery version '1.0-ml'; " +
		" " +
		"  for $doc in /log[log-entry/@competition = '@@COMPETITION' and log-entry/@discipline = '@@DISCIPLINE']" +
		"  return" +
		"    try{ xdmp:document-delete(xdmp:node-uri($doc)) } catch ($e){()}";

	public static String ALL_INDIVIDUAL =
		"xquery version '1.0-ml'; " +
		" " +
		" let $data-uri := 'http://data.press.net/data/odf/' " +
		" for $uri in cts:uris($data-uri) " +
		" return " +
		" try{ xdmp:document-delete( $uri ) } " +
		" catch ($e){()} ";

	public static String ALL_BY_DIRECTORY =
		"xquery version '1.0-ml'; " +
		" " +
		"xdmp:directory-delete( 'http://data.press.net/data/odf/' )";
}