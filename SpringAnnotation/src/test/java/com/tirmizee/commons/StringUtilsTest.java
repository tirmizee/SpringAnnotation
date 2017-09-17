package com.tirmizee.commons;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tirmizee.core.commons.StringUtils;
import com.tirmizee.core.config.AppConfig;

/**
 * @author tirmizee
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={AppConfig.class})
public class StringUtilsTest {

	@Test
	public void isTrueWhenEqualsStringTwoParams(){
		//given
		String strOne = "Over",
			   strTwo = new String("Over"),
			   strThree = null,
			   strFour = null;
		//when
		boolean isEqualFirst = StringUtils.equals(strOne, strTwo),
				isEqualSecond = StringUtils.equals(strThree, strFour);
		//then
		assertThat(isEqualFirst).isTrue();
		assertThat(isEqualSecond).isTrue();
	}
	
	@Test
	public void isFalseWhenEqualsStringTwoParams(){
		//given
		String strOne = "Over",
			   strTwo = new String("over"),
			   strNull = null;
			   
		//when
		boolean isEqualFirst = StringUtils.equals(strOne, strTwo),
				isEqualSecond = StringUtils.equals(strNull, strOne),
				isEqualThird = StringUtils.equals(strTwo, strNull);
		//then
		assertThat(isEqualFirst).isFalse();
		assertThat(isEqualSecond).isFalse();
		assertThat(isEqualThird).isFalse();
	}
	
	@Test
	public void isTrueWhenEqualsStringUnlimitedParams(){
		//given
		String Over = "Over",
				Null = null;
		//when
		boolean isEqualFirst = StringUtils.equals(Over, Over,Over, Over,Over, Over,Over, Over),
				isEqualSecond = StringUtils.equals(Null, Null,Null, Null,Null, Null);
		//then
		assertThat(isEqualFirst).isTrue();
		assertThat(isEqualSecond).isTrue();
	}
	
	@Test
	public void isFalseWhenEqualsStringUnlimitedParams(){
		//given
		String Over = "Over",
			   over = new String("over"),
			   Null = null;
			   
		//when
		boolean isEqualFirst = StringUtils.equals(Over, Over,Over, Over,Null),
				isEqualSecond = StringUtils.equals(Null, Over, over, over, Null);
		//then
		assertThat(isEqualFirst).isFalse();
		assertThat(isEqualSecond).isFalse();
	}
	
}
