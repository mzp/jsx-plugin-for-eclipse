package net.vvakame.ide.jsx.editors.viewerconfiguration;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

class XMLWhitespaceDetector implements IWhitespaceDetector {

	@Override
	public boolean isWhitespace(char c) {
		return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
	}
}
