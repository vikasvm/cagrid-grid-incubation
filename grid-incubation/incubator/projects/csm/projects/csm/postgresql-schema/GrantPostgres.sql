-- Copyright � 2010 Emory University
-- 
-- Permission is hereby granted, free of charge, to any person obtaining a
-- copy of this software and associated  documentation files (the "Software"),
-- to deal in the Software without restriction, including without limitation 
-- the rights to use, copy, modify, merge, publish, distribute, sublicense, 
-- and/or sell copies of the Software, and to permit persons to whom the
-- Software is furnished to do so, subject to the following conditions: The
-- above copyright notice and this permission notice shall be included in all
-- copies or substantial portions of the Software. 
-- 
-- THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
-- EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
-- MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO
-- EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
-- OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
-- ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
-- DEALINGS IN THE SOFTWARE.

-- Grant privileges on CSM tables to users.

GRANT SELECT,INSERT,UPDATE,DELETE ON CSM_APPLICATION TO :ADMIN_USER;
GRANT SELECT,INSERT ON CSM_APPLICATION TO :APP_USER;

GRANT SELECT,INSERT,UPDATE,DELETE ON CSM_GROUP TO :ADMIN_USER;
GRANT SELECT ON CSM_GROUP TO :APP_USER;

GRANT SELECT,INSERT,UPDATE,DELETE ON CSM_PRIVILEGE TO :ADMIN_USER;
GRANT SELECT ON CSM_PRIVILEGE TO :APP_USER;

GRANT SELECT,INSERT,UPDATE,DELETE ON CSM_PROTECTION_ELEMENT TO :ADMIN_USER;
GRANT SELECT ON CSM_PROTECTION_ELEMENT TO :APP_USER;

GRANT SELECT,INSERT,UPDATE,DELETE ON CSM_PROTECTION_GROUP TO :ADMIN_USER;
GRANT SELECT ON CSM_PROTECTION_GROUP TO :APP_USER;

GRANT SELECT,INSERT,UPDATE,DELETE ON CSM_PG_PE TO :ADMIN_USER;
GRANT SELECT ON CSM_PG_PE TO :APP_USER;

GRANT SELECT,INSERT,UPDATE,DELETE ON CSM_ROLE TO :ADMIN_USER;
GRANT SELECT ON CSM_ROLE TO :APP_USER;

GRANT SELECT,INSERT,UPDATE,DELETE ON CSM_ROLE_PRIVILEGE TO :ADMIN_USER;
GRANT SELECT ON CSM_ROLE_PRIVILEGE TO :APP_USER;

GRANT SELECT,INSERT,UPDATE,DELETE ON CSM_USER TO :ADMIN_USER;
GRANT SELECT ON CSM_USER TO :APP_USER;

GRANT SELECT,INSERT,UPDATE,DELETE ON CSM_USER_GROUP TO :ADMIN_USER;
GRANT SELECT ON CSM_USER_GROUP TO :APP_USER;

GRANT SELECT,INSERT,UPDATE,DELETE ON CSM_USER_GROUP_ROLE_PG TO :ADMIN_USER;
GRANT SELECT ON CSM_USER_GROUP_ROLE_PG TO :APP_USER;

GRANT SELECT,INSERT,UPDATE,DELETE ON CSM_USER_PE TO :ADMIN_USER;
GRANT SELECT ON CSM_USER_PE TO :APP_USER;

GRANT SELECT,INSERT,UPDATE,DELETE ON CSM_FILTER_CLAUSE TO :ADMIN_USER;
GRANT SELECT ON CSM_FILTER_CLAUSE TO :APP_USER;

GRANT SELECT,INSERT,UPDATE,DELETE ON CSM_REMOTE_GROUP TO :ADMIN_USER;
GRANT SELECT ON CSM_REMOTE_GROUP TO :APP_USER;

GRANT SELECT,INSERT,UPDATE,DELETE ON CSM_REMOTE_GROUP_SYNC_RECORD TO :ADMIN_USER;
GRANT SELECT ON CSM_REMOTE_GROUP_SYNC_RECORD TO :APP_USER;

GRANT SELECT,UPDATE ON CSM_FILTER_CLAUSE_SEQ TO :ADMIN_USER, :APP_USER;
GRANT SELECT,UPDATE ON CSM_APPLICATI_APPLICATION__SEQ TO :ADMIN_USER, :APP_USER;
GRANT SELECT,UPDATE ON CSM_GROUP_GROUP_ID_SEQ TO :ADMIN_USER, :APP_USER;
GRANT SELECT,UPDATE ON CSM_PG_PE_PG_PE_ID_SEQ TO :ADMIN_USER, :APP_USER;
GRANT SELECT,UPDATE ON CSM_PRIVILEGE_PRIVILEGE_ID_SEQ TO :ADMIN_USER, :APP_USER;
GRANT SELECT,UPDATE ON CSM_PROTECTIO_PROTECTION_E_SEQ TO :ADMIN_USER, :APP_USER;
GRANT SELECT,UPDATE ON CSM_PROTECTIO_PROTECTION_G_SEQ TO :ADMIN_USER, :APP_USER;
GRANT SELECT,UPDATE ON CSM_ROLE_ROLE_ID_SEQ TO :ADMIN_USER, :APP_USER;
GRANT SELECT,UPDATE ON CSM_ROLE_PRIV_ROLE_PRIVILE_SEQ TO :ADMIN_USER, :APP_USER;
GRANT SELECT,UPDATE ON CSM_USER_USER_ID_SEQ TO :ADMIN_USER, :APP_USER;
GRANT SELECT,UPDATE ON CSM_USER_GROU_USER_GROUP_I_SEQ TO :ADMIN_USER, :APP_USER;
GRANT SELECT,UPDATE ON CSM_USER_GROU_USER_GROUP_R_SEQ TO :ADMIN_USER, :APP_USER;
GRANT SELECT,UPDATE ON CSM_USER_PE_USER_PROTECTIO_SEQ TO :ADMIN_USER, :APP_USER;
GRANT SELECT,UPDATE ON CSM_REMOTE_GROUP_SYNC_RECORD_ID_SEQ TO :ADMIN_USER, :APP_USER;

 
