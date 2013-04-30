package com.github.freebook

class LatexStripper {
	
	def stripString(text) {
		replaceTags text
	}
	
	def replaceTags(text) {
		text.replaceAll('\\{', '').replaceAll('\\}', '')
	}

}
