declare namespace openMDR = "http://www.cagrid.org/schema/openMDR";
declare namespace request="http://exist-db.org/xquery/request";
declare namespace xmldb="http://exist-db.org/xquery/xmldb";
declare namespace util="http://exist-db.org/xquery/util";
declare namespace session="http://exist-db.org/xquery/session";

     
import module namespace 
   lib-util="http://www.cagrid.org/xquery/library/util" 
   at "../library/m-lib-util.xquery";
   
import module namespace 
   lib-rendering="http://www.cagrid.org/xquery/library/rendering"
   at "../web/m-lib-rendering.xquery";   
   
declare variable $title as xs:string := "Fix preferred designations";
   
   
   
   declare option exist:serialize "media-type=text/html method=xhtml doctype-public=-//W3C//DTD&#160;XHTML&#160;1.0&#160;Transitional//EN doctype-system=http://www.w3.org/TR/2002/REC-xhtml1-20020801/DTD/xhtml1-transitional.dtd";
   
session:create(),   
   
lib-rendering:txfrm-webpage($title,
   element div {
      let $item as element()* := lib-util:mdrElements()[.//openMDR:preferred_designation]
      return 
      if (count($item[not(.//openMDR:preferred_designation='true')])=0)
      then ('no broken names reported')
      else 
         (
         for $errors in $item[not(.//openMDR:preferred_designation='true')]//openMDR:name 
         return update value $errors//openMDR:preferred_designation[1] with 'true',
         'names fixed'
         )
      }
)