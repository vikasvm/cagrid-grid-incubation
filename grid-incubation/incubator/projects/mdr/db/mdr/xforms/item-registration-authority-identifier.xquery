declare namespace cgMDR = "http://www.cancergrid.org/schema/cgMDR";

import module namespace 
   lib-util="http://www.cancergrid.org/xquery/library/util" 
   at "../library/m-lib-util.xquery"; 
   
declare option exist:serialize "media-type=application/xml method=xml";

<item-registration-authority-identifier>
   <item>
      <label>Select... </label>
      <value> </value>
   </item>
   {
   for $item in lib-util:mdrElements('registration_authority')
         let $label:= data($item//cgMDR:organization_name)
         let $value:= data($item//@organization_identifier)
         return
               <item>
                  <label>{$label}</label>
                  <value>{$value}</value>
               </item>
         }
</item-registration-authority-identifier>
