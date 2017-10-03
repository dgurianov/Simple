import sys
import sqlite3
import logging

class DbConnector(object):
	def __init__(self,in_file):
		self.data_file = in_file
		try :
			self.connection = sqlite3.connect(self.data_file)
			logging.debug("Succeded open sql connection using {}".format(self.data_file))
		except BaseException as ex :
			logging.error("Failed to open connection to sql DB using {}. \nException : \n\t\t{}".format(self.data_file,ex))
			sys.exit(1)
			
	def get_cursor(self):
		'''Return sqlite cursor'''
		logging.debug("Gave away cursor")
		return self.connection.cursor()
		
	def do_commit(self):
		'''Commits data'''
		logging.debug("Doing commit.")
		self.connection.commit()
