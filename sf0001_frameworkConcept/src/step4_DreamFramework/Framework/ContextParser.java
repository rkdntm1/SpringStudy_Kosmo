package step4_DreamFramework.Framework;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ContextParser {
	// Parse: 해석
	public static List<Pair<String, String>> parseContext() throws Exception {
		List<Pair<String, String>> ret = new ArrayList<>();
		// SAX, DOM 의 두 종류 라이브러리가 있습니다.
		// DOM 한번읽어서 메모리에 객체를 만들어놓고 마음대로 :용량이 제한적 / 접근이 자유로움, 편리 
		// SAX 한줄 읽고 해석 ---  :느림, 순차접근, 불편 / 용량이 제한 x
		
		// Get Document Builder(해석기)
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Build Document
		Document document = builder.parse(new File("./src/step4_DreamFramework/root_context.xml"));
		document.getDocumentElement().normalize();
		NodeList nList = document.getElementsByTagName("Bean");
		for (int i = 0; i < nList.getLength(); i++) {
			Node node = nList.item(i);
			Element eElement = (Element) node;
			ret.add(new Pair<>(eElement.getElementsByTagName("Name").item(0).getTextContent(), 
					eElement.getElementsByTagName("Path").item(0).getTextContent()));
		}
		return ret;
	}
}
