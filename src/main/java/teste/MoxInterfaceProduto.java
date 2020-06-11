package teste;


import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;

import br.com.prod.datasource.model.Produto;


@Provider
@Consumes(MediaType.TEXT_PLAIN)
public class MoxInterfaceProduto extends MOXyJsonProvider{

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return genericType.equals(Produto.class);
	}
	
	@Override
	public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
			InputStream entityStream) throws IOException, WebApplicationException {
		return super.readFrom(type, genericType, annotations, mediaType, httpHeaders, entityStream);
	}


	
	
}
