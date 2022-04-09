
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.example.usuarios.UsuariosEJBRemote;

public class Main {

    public static void main(String[] args) throws NamingException {
        // TODO Auto-generated method stub

        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        props.put(Context.PROVIDER_URL,"http-remoting://127.0.0.1:8080");

        Context ctx  = new InitialContext(props);
        String jndiName = "ejb:practico-tse-uno/practico-tse-uno-ejb/UsuariosEJB!org.example.usuarios.UsuariosEJBRemote";
        UsuariosEJBRemote usuario = (UsuariosEJBRemote)ctx.lookup(jndiName);

        System.out.println("##########################################");
        System.out.println("Agregar usuario");
        System.out.println(usuario.getUsuario());

        System.out.println("##########################################");

    }

}
