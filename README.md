# logParser
parser for reading unsystematized log
-- данное решение было написано на коленке для парсинга не стандартизированного лога выполнения расчетов.
-- из-за переполнения типов данных и урезания сообщений, отсутствует возможность получить информацию о типах расчетов и времени выполнения на уровне БД, где хранятся логи.
-- для решения задачи был написан данный парсер, по косвенным признакам определяющий тип каждого расчета и время его выполнения. 
-- на выходе отражено кол-во различных расчетов с соответствующими временами выполнения за период, а так-же не распознанные расчеты, если таковые есть.
