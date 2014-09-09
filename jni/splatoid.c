#include "mu_verdigris_splatoid_Splatoid.h"
#include <Python.h>

jint Java_mu_verdigris_splatoid_Splatoid_nativeTest(
	JNIEnv *jenv, jobject jobj)
{
	static const char msg[] = "Hello\n";
	FILE *f;
	int ret = 1234;

	f = fopen("/sdcard/splatoid-was-here", "w");

	if (f == NULL) {
		ret = -1;
		goto exit_now;
	}

	if (fwrite(msg, sizeof(msg), 1, f) != 1) {
		ret = -1;
		goto exit_close;
	}

exit_close:
	fclose(f);
exit_now:
	return ret;
}

jint Java_mu_verdigris_splatoid_Splatoid_pythonTest(
	JNIEnv *jenv, jobject jobj, jstring jscript)
{
	const char *script;
	int ret = 0;

	script = (*jenv)->GetStringUTFChars(jenv, jscript, NULL);

	if (script == NULL) {
		ret = -1;
		goto exit_now;
	}

	Py_SetProgramName("splatoid");
	Py_Initialize();

	if (PyRun_SimpleString(script)) {
		ret = -1;
		goto exit_finalize;
	}

exit_finalize:
	Py_Finalize();
exit_now:
	return ret;
}
