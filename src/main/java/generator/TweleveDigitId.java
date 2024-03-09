package generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class TweleveDigitId implements IdentifierGenerator
{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException 
	{
		String prefix="9";
		Random random=new Random();
		long randomNumber=random.nextLong(100000000L);
		prefix+=randomNumber;
		return Long.parseLong(prefix);
	}
	
}
