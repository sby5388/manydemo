#include <jni.h>
#include <stdio.h>
#include <string.h>
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jint JNICALL
Java_com_by5388_xw_android_jnidemo_tools_Tools_intGetSumFromJNIAnInt(JNIEnv *env, jclass type, jint a, jint b) {
    return a + b;

}

JNIEXPORT jstring JNICALL
Java_com_by5388_xw_android_jnidemo_tools_Tools_stringFromJNI(JNIEnv *env, jobject instance) {

    const char *returnValue = "hello from jni";
    return (*env)->NewStringUTF(env, returnValue);
}

JNIEXPORT void JNICALL
Java_com_by5388_xw_android_jnidemo_tools_Tools_setPersonNameNative(JNIEnv *env, jobject instance, jstring name) {
    //调用实例方法
    const char *Person = "com/by5388/xw/android/jnidemo/tools/Person";

    jclass personClass = (*env)->FindClass(env, Person);
    //通过构造方法来创建对象:构造方法的默认格式?
    jmethodID jmethodID1 = (*env)->GetMethodID(env, personClass, "<init>", "()V");
    //创建对象？
    jobject person = (*env)->NewObject(env, personClass, jmethodID1);

    jmethodID jmethodID2 = (*env)->GetMethodID(env, personClass, "setName",
                                               "(Ljava/lang/String;)V");
    (*env)->CallVoidMethod(env, person, jmethodID2, name);
}

JNIEXPORT void JNICALL
Java_com_by5388_xw_android_jnidemo_tools_Tools_getMiALong(JNIEnv *env, jclass type, jint number) {
    jint result = 1;
    while (number > 0) {
        result *= number;
        number--;
    }

    const char *className = "com/by5388/xw/android/jnidemo/tools/Tools";
    //TODO 下面的当jclass是同一个时，是否可以直接使用 实参的对象？
    jclass classObj = (*env)->FindClass(env, className);
    //最后一个参数：JNI中java类型的简写
    //参考：http://hubingforever.blog.163.com/blog/static/171040579201151722833782/
    //此处调用的是void( int )

    jmethodID methodObj = (*env)->GetStaticMethodID(env, classObj, "printResult", "(I)V");
    //指针，类，方法，参数（可变参数，与上一行最后一个参数相关）
    (*env)->CallStaticVoidMethod(env, classObj, methodObj, result);

}

JNIEXPORT jstring JNICALL
Java_com_by5388_xw_android_jnidemo_tools_Tools_sayHelloFromJni(JNIEnv *env, jclass type, jstring name_) {
    const char *name = (*env)->GetStringUTFChars(env, name_, 0);
    // TODO
    //const char *returnValue = stpcpy(returnValue,);
    (*env)->ReleaseStringUTFChars(env, name_, name);

    return (*env)->NewStringUTF(env, name);
}

JNIEXPORT jintArray JNICALL
Java_com_by5388_xw_android_jnidemo_tools_ArrayTools_sortIntegerArrayByJni(JNIEnv *env, jclass type,
                                                                          jintArray numbers_) {
    jint *numbers = (*env)->GetIntArrayElements(env, numbers_, NULL);
    //数组长度
    jint array_length = (*env)->GetArrayLength(env, numbers_);

    jint *cint = (*env)->GetIntArrayElements(env, numbers_, NULL);
    int i = 0;
    int j = 0;
    int k = 0;
    for (i = 0; i < array_length - 1; i++) {
        for (j = 0; j < array_length - i - 1; j++) {
            if (cint[j] > cint[j + 1]) {
                k = cint[j];
                cint[j] = cint[j + 1];
                cint[j + 1] = k;
            }
        }
    }

    (*env)->ReleaseIntArrayElements(env, numbers_, cint, 0);
    return numbers_;
}

JNIEXPORT jstring JNICALL
Java_com_by5388_xw_android_jnidemo_tools_NetTools_getNetIPFromJni(JNIEnv *env, jobject instance) {
    // TODO
    return (*env)->NewStringUTF(env, "192.168.0.12");
}

JNIEXPORT void JNICALL
Java_com_by5388_xw_android_jnidemo_tools_NumberTools_sortNumberByJni(JNIEnv *env, jclass type, jintArray intArray,
                                                                     jint length) {
    jint *integers = (*env)->GetIntArrayElements(env, intArray, NULL);
    //获取数组长度的函数
    jint arrayLength = (*env)->GetArrayLength(env, intArray);
    printf("arrayLength = %d\n", arrayLength);

    printf("length = %d\n", length);
    printf("by5388\n");

    int count = sizeof(integers) / sizeof(integers[0]);
    printf("size==%d\n", count);
    // TODO
    jint i = 0;
    for (i = 0; i <= count; i++) {
        printf("%d \n", integers[i]);
    }
    //释放空间，对象是否为空
    (*env)->ReleaseIntArrayElements(env, intArray, integers, 0);
}

JNIEXPORT void JNICALL
Java_com_by5388_xw_android_jnidemo_tools_NumberTools_showFromJni(JNIEnv *env, jclass type, jstring name_) {
    const char *name = (*env)->GetStringUTFChars(env, name_, 0);

    printf("my name is  = %s\n", name);

    (*env)->ReleaseStringUTFChars(env, name_, name);
}
#ifdef __cplusplus
}
#endif