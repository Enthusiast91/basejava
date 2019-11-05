package com.enthusiast91.webapp;

import com.enthusiast91.webapp.storage.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayStorageTest.class,
        SortedArrayStorageTest.class,
        ListStorageTest.class,
        MapUuidStorageTest.class,
        MapNameStorageTest.class})
public class AllStorageTest {
}
